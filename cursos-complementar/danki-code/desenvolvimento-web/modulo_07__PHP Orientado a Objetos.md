# PHP Orientado a Objetos

## Aula 01

### **Introdução a orientação a objetos**

**Orientação a Objetos no PHP ou OPP**

```php
procedural

	define();
	$varivael
	func();

ORIENTACAO A OBJETOS NO PHP OU OOP


	Pessoa//objeto, são classes
	{
		nome //atributos
		idade
		peso

		crescer()//metodos
		comer()
	}

```

```php
<?php
class Pessoa{
    //Objeto pessoa
    //atributos
    private $nome = 'André';
    private $idade = '26';
    private $peso = '70kg';
    //metodos
    public function crescer(){
        $this->comer(); //trabalha com um metodo dentro do objeto
        echo 'estou crescendo';
    }
    //private disponivel apenas dentro da class
    private function comer(){
        echo 'estou comendo';
    }
}


//Instanciar, criar o objeto
$pessoa = new Pessoa;
$pessoa2 = new Pessoa;

//chamar o metodo
$pessoa->crescer();


?>
```

## Aula 02

### Public, private e static

`index.php`

```php+HTML
<?php
//adicionando o arquivo da class para poder ser utilizado include('/caminho')
include('exemplo.class.php');

//Instancia de objeto, pode se passar parametros na criação da class 
$exemplo = new Exemplo();
//chamar atributos de uma classe, 'variaveis'
//$exemplo -> var1 = 'Olá'; // retorna um erro pos o atributo esta apenas disponivel dentro da class 

// não retorna erro pos a variavel é publica e pode ser acessada fora da class
$exemplo->var2 = 'André';

echo $exemplo->var2;
//variaveis diferentes armazenam o mesmo objeto porém tem valores diferentes.
$exemplo2 = new Exemplo;
$exemplo2->var2='joice';
echo'</br>';
echo $exemplo2 ->var2;
echo'</br>';

//static não é acessivel através da estancia criada
//não pode ser atibuido valores individuais 
//echo $exemplo -> var3;

//chamar um atributo static atraves da class
echo Exemplo::$var3;
//possivel alterar seu valor de forma direta e não em forma de class
Exemplo::$var3 = 'Outra variavel';
echo Exemplo::$var3;
//não precisa instanciar a variavel para chamar o metodo
Exemplo::metodoEstatico();


$exemplo ->setVar1('Exemplo');//setando o metodo com valor 
echo $exemplo->pegaVar1();// exibe o metodo com retorno

$exemplo2 = new Exemplo;
$exemplo2 ->setVar1('Exemplo 2');
echo $exemplo2->pegaVar1();

?>
```

`exemplo.class.php`

```php+HTML
<?php
class Exemplo{
    private $var1;
    public $var2;
//não pode ser atibuido valores individuais 
    public static $var3 = 'estatico';

//Public funciona em qualquer lugar
    public function metodo(){

    }
//Private só conseguimos acessar dentro da class
    private function metodo2(){

    }
//metodo e função são a mesma coisa
    public static function metodoEstatico(){
        echo 'metodo static';
    }
//fução recebe um parametro
    public function setVar1($var1){
        //faz referencia para utilizar $var1 da class
        $this->var1 = $var1;
        
    }
    public function pegaVar1(){
        return $this->var1;
    }


}


?>
```

## Aula 03

### Final class, heranças, protected

> Final class é uma classe final e não pode ser herdada 
>
> public function é acessada em todo o script 
>
> private function esta apenas disponível dentro da classe que foi declarada e não pode ser herdada 
>
> protected function garante que seus métodos e propriedades não possam ser acessados externamente mas é possível herdar em class filhas. 

```php
<?php

//final não permite que a class seja herdada
/*final*/ class Filha{


    protected function funcaoTeste(){
        echo 'chamando função teste';
    }

    public function printHello(){
        echo 'Olá Mundo!';
    }

}
// Não é possivel fazer uma class herdar uma classe final

//extends indica que a class PAI ira herdar os metodos da class FILHA
class Pai extends Filha {
    public function printHello()
    {
        //para chamar a função original
        parent::printHello();
        echo 'nova função';
    }

    public function mostrarTchau(){
        echo'Tchau Mundo!';
        echo'<br/>';
        $this->funcaoTeste();
    }
}
/*
$pai = new Pai;
$pai->mostrarTchau();
*/

//Instanciar class final

$filha = new Filha;
$filha->printHello();

//ao herdar a classe Filha a class Pai tem acesso a todos metodos da classe herdada
$pai = new Pai;
$pai->printHello();
$pai->mostrarTchau();

?>




```

## Aula 04

### Abstract, self e mais conceitos

```php
<?php
//declarar o nome da class em maiusculo é uma boa pratica

//abstract não pode ser instanciada ela é apenas herdada
abstract class Teste{
    public  function func1(){
        echo 'chamando função 1';
    }
    abstract function func2();
}
class Principal2{
    public static function outroMetodoEstatico(){
        echo 'meu outro metodo';
    }
}


class Principal extends Teste{
    //quando herda um metodo abstract é necessario declarar ele na classe principal
    public function func2(){
        echo 'estou declarando oficialmente um metodo abstrato';
    }
    public static function metodoestatico(){
        echo'metodo estatico';

    }

    public function funcao(){
        //Principal::metodoestatico();
        //self e usado para acessar um metodo estatico que esta apenas disponivel para essa classe
        self::metodoestatico();

        Principal2::outroMetodoEstatico();

    }
}


$principal = new Principal;
$principal->func1();

$principal->func2();
$principal->funcao();

?>
```

## Aula 05

### Interface e implements

`interface1.php`

```php
<?php
//não pode ser instanciada, mas segue o mesmo principio de uma classe instanciada

//conjunto de metodos, apenas cria os metodos, a classe principal diz o que o metodo ira fazer
interface interface1{
    public function printOnScreen($par);

}

?>
```

`index.php`

```php
<?php
include ('interface1.php');

class Teste implements interface1 {
    public function printOnScreen($par)
    {
        echo $par;
    }

}

$teste= new Teste;

$teste->printOnScreen('Olá Mundo!');

?>
```

## Aula 06

### Métodos mágicos

`class1.php`

```php
<?php

//__construct ao instanciar o objeto o primeiro metodo a ser procurado, metodo construtor
class class1
{
    private $nome;
    private $idade;
    //metodos magicos, que vem com a class
    public  function __construct($nome,$idade)
    {
        $this->nome = $nome;
        $this->idade = $idade;
    }
    public function getNome(){
        return $this->nome;
    }

    public function getIdade(){
        return $this->idade;
    }
}


?>
```

`index.php`

```php
<?php
include ('class1.php');
$teste = new class1('André', 26);

echo $teste->getNome();
echo $teste->getIdade();

?>
```

## Aula 07

### Namespace e use keywords

`index.php`

```php
<?php
include('Class1.php');
include('Class2.php');
/*
//Session da o contexto de diretorio para a Class
$class1 = new \Sessao1\Class1();
*/

//e possivel dar um apelido para a class 
use \Sessao1\Class1 as classe_exemplo;
$class1 = new classe_exemplo;
?>
```

`Class1.php`

```php
<?php

//namespace divide as classes em sessões "dividir por pastas"

namespace Sessao1;
//é possivel utilizar outras sessões dentro de um sessão
use Sessao2\Class2;
class Class1 {

    function __construct(){
        echo'Classe instanciada';
//possivel instanciar outra classe junto a primeira instanciada, desde que seja feito o include dela
    /*   
    new \Class2();
// o uso da \ para indicar o diretorio da class
*/
    new \Sessao2\Class2();

}
}

?>
```

`Class2.php`

```php
<?php
namespace Sessao2;
class Class2{
    function __construct(){

        echo 'Class2 instanciada';
    }
}

?>
```

## Aula 08

### Autoload

`index.php`

```php
<?php

include ('config.php');

new Utilidades();

new Home\Inicial();
 ?>

```

`config.php`

```php
<?php
function myAutoLoad($class){

  //mudança na \ do diretorio para que não tenha problema com servidores linux ao ler diretorios
  $class = str_replace('\\','/',$class);
  echo $class;
  //verifica se o arquivo existe
  if (file_exists('classes/'.$class.'.php')) {
    //faz o include
    include('classes/'.$class.'.php');
  }

}

//registra a função para o php chamar automaticamente
spl_autoload_register('myAutoLoad');
 ?>

```

`utilidades.php`

```php
<?php

class Utilidades
{

  function __construct()
  {
    echo "Classe Utilidades foi chamada com sucesso";
  }
}


 ?>

```

`inicial.php`

```php
<?php
namespace Home;
class Inicial
{

  function __construct()
  {
    echo "Classe Inicial chamada com sucesso!";
  }
}
 ?>

```

## Aula 09

### Constantes no PHPOO

```php
<?php

class minhaClasse
{
  //declarção de constante
  const VALOR = 300;
  public function __construct()
  {
    echo self::VALOR;
  }
}

echo minhaClasse::VALOR;
 ?>

```

## Aula 10

### Design paterns

```php
<?php
/*
class Dog
{

  function __construct()
  {
    echo "Class Dog";
  }
}


class Cat
{

  function __construct()
  {
    echo "Class Cat";
  }
}

//Singleton pattern
class Animal
{

  public  static function build($nomeClasse){
    if (class_exists($nomeClasse)) {
      return new $nomeClasse;
    }else {
      die('Ops, a class não existe');
    }

  }
}


//new Dog();

//Singleton pattern
Animal::build('Cat');
Animal::build('Mouse');
*/

//Facade

//Adicionar/Fechar Carrinho - Carrinho
//Calcular Frete - Frete
//Fechar Pedido - Pedido

//Temos uma classe responsavel para cada ação

class Carrinho{
  public function fecharCarrinho(){
    echo "carrinho fechado";
  }
}

class Frete{
  public function calcularFrete(){}
}

class Pedido{
  public function fecharPedido(){}
}

class Loja{
  public function finalizarCompra(){
    $this->fecharCarrinho();
    $this-> calcularFrete();
    $this->fecharPedido();

  }

  public function fecharCarrinho(){
    $carrinho = new Carrinho();
    $carrinho->fecharCarrinho();
  }
}


$Loja = new Loja();
$Loja -> finalizarCompra();

 ?>

```

