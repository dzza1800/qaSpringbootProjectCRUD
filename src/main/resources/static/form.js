function alertForm(){
    let user = document.forms["userForm"]["Username"].value;
    let pass = document.forms["userForm"]["Password"].value;
    if(user == "" && pass != ""){
        alert("Enter Username");
}
    else if(user != "" && pass == ""){
        alert("Enter Password");
    }
    else if(user == "" && pass == ""){
        alert("Enter Credentials");
}
}