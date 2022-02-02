<?php

// class to handle a file 
class DBConnect{


	private $file; // ruta y nombre del fichero
    private $mode; // modo de acceso al fichero
    private $handle; // puntero al fichero
    
    public function __construct($file) {
        $this->file=$file;
    }

    public function getFile() {
        return $this->file;
    }

    public function getMode() {
        return $this->mode;
    }

    public function getHandle() {
        return $this->handle;
    }

    public function setFile($file) {
        $this->file = $file;
    }

    public function setMode($mode) {
        $this->mode = $mode;
    }

    public function setHandle($handle) {
        $this->handle = $handle;
    }

	
	

// PRIMER MÈTODE BÀSIC PER A MANIPULAR UN FITXER EN GENERAL: OBRIR-LO
	private function openFile($mode) {
        $this->mode=$mode;
        $this->handle=fopen($this->file, $this->mode);
        // TRUE si abre el fichero correctamente
        $result=($this->handle)?TRUE:FALSE;
        
        return $result;
    }
    
// SEGON MÈTODE BÀSIC PER A MANIPULAR UN FITXER EN GENERAL: TANCAR-LO
	private function closeFile() {
        fclose($this->handle);
	}

    //-------
// TERCER MÈTODE BÀSIC PER A MANIPULAR UN FITXER EN GENERAL: ESCRIURE TOTES LES DADES DE NOU
	public function writeToFile($data) {
        $result=FALSE;
        
        if (count($data)>0) {
            // abre el fichero en modo write
            if ($this->openFile("w")) {
                foreach ($data as $line) {
                    fputs($this->getHandle(), $line);
                }
            }
            $this->closeFile();            
            $result=TRUE;
        }
        
        return $result;
    }

// QUART MÈTODE BÀSIC PER A MANIPULAR UN FITXER EN GENERAL: AFEGIR UNA LÍNIA NOVA AL FINAL DE TOT
	public function addNewLine($newLine) {
        $result=FALSE;

        
        if ($this->openFile("a+")) {
            fputs($this->getHandle(), $newLine);
            $this->closeFile();
            $result=TRUE;
        }

        return $result;
    }

// CINQUÈ MÈTODE BÀSIC PER A MANIPULAR UN FITXER EN GENERAL: RECOLLIR TOTES LES LÍNIES DEL FITXER
	public function readAllLines(){

		$lines=array();
		if($this->openFile("r")){

				while(!feof($this->handle)){
					   $lines[]=fgets($this->handle);

				}
				$this->closeFile();
		}

		return $lines;
	}

	
	//NOMÉS S'HI PODEN FICAR MÈTODES GENERALS PER A TOTS ELS FITXERS

}
?>
