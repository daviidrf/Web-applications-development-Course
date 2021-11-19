<?php
require_once "iTemplate.php";

class Template implements iTemplate
{
    private $vars = [];

    public function setVariable($name, $var)
    {
        $this -> vars[$name] = $var;
    }

    public function getHtml()
    {
        $template="";

        foreach($this -> vars as $name => $value) {
            $template .= '{Ciudad: ' . $name . '}--País: ' . $value . "<br>";
        }

        echo $template;
    }
}
