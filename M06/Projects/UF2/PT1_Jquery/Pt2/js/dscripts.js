$(document).ready(function () {
    for (let index = 0; index < 8; index++) {
        if(!index % 2 == 0){
            $("tr:odd td:even").css("background-color","black");
        } else {
            $("tr:even td:odd").css("background-color","black");
        }
        
        
    }
    

});