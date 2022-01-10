<?php

class CategoryFormValidation {

    const ADD_FIELDS = array('id','name');
    const MODIFY_FIELDS = array('id','name');
    const DELETE_FIELDS = array('id');
    const SEARCH_FIELDS = array('id');
    
    const NUMERIC = "/[^0-9]/";
    const ALPHABETIC = "/[^a-z A-Z]/";
    
    public static function checkData($fields) {
        $id=NULL;
        $name=NULL;
        
        foreach ($fields as $field) {
            switch ($field) {
                case 'id':
                    // filter_var retorna los datos filtrados o FALSE si el filtro falla
                    $id=trim(filter_input(INPUT_POST, 'id'));
                    $idValid=!preg_match(self::NUMERIC, $id);
                    if (empty($id)) {
                        array_push($_SESSION['error'], CategoryMessage::ERR_FORM['empty_id']);
                    }
                    else if ($idValid == FALSE) {
                        array_push($_SESSION['error'], CategoryMessage::ERR_FORM['invalid_id']);
                    }
                    break;
                case 'name':
                    $name=trim(filter_input(INPUT_POST, 'name'));
                    $nameValid=!preg_match(self::ALPHABETIC, $name);
                    if (empty($name)) {
                        array_push($_SESSION['error'], CategoryMessage::ERR_FORM['empty_name']);
                    }
                    else if ($nameValid == FALSE) {
                        array_push($_SESSION['error'], CategoryMessage::ERR_FORM['invalid_name']);
                    }
                    break;
                case 'xx':
                    // filter_var retorna los datos filtrados o FALSE si el filtro falla
                    $id=trim(filter_input(INPUT_POST, 'id'));
                    $idValid=filter_var($id, FILTER_SANITIZE_NUMBER_INT);
                    if ($idValid == FALSE) {
                        array_push($_SESSION['error'], CategoryMessage::ERR_FORM['invalid_id']);
                    }
                    break;
                case 'xx':
                    $name=trim(filter_input(INPUT_POST, 'name'));
                    $nameValid=filter_var($name, FILTER_SANITIZE_STRING);
                    if ($nameValid == FALSE) {
                        array_push($_SESSION['error'], CategoryMessage::ERR_FORM['invalid_name']);
                    }
                    break;
            }
        }
        
        $category=new Category($id, $name);
        
        return $category;
    }
    
}
