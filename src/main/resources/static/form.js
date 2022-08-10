function openUserSection() {
    document.getElementById("UserSection").style.display = "block";
    document.getElementById("Userbutton").style.display = "none";
    document.getElementById("UserSection").style.width = "100%";
    document.getElementById("button_list").style.display = "none";  
    }
function closeUserSection() {
    document.getElementById("UserSection").style.display = "none";
    document.getElementById("Userbutton").style.display = "block";
    document.getElementById("UserSection").style.width ="0%"; 
    document.getElementById("button_list").style.display = "block";
    }
function openCoinsSection() {
    document.getElementById("CoinsSection").style.display = "block";
    document.getElementById("Userbutton").style.display = "none";
    document.getElementById("CoinsSection").style.width = "100%";
    document.getElementById("button_list").style.display = "none";  
    }
function closeCoinsSection() {
    document.getElementById("CoinsSection").style.display = "none";
    document.getElementById("Userbutton").style.display = "block";
    document.getElementById("CoinsSection").style.width ="0%"; 
    document.getElementById("button_list").style.display = "block";
    }
function openOrdersSection() {
    document.getElementById("OrderSection").style.display = "block";
    document.getElementById("Userbutton").style.display = "none";
    document.getElementById("OrderSection").style.width = "100%";
    document.getElementById("button_list").style.display = "none";  
    }
function closeOrdersSection() {
    document.getElementById("OrderSection").style.display = "none";
    document.getElementById("Userbutton").style.display = "block";
    document.getElementById("OrderSection").style.width ="0%"; 
    document.getElementById("button_list").style.display = "block";
    }

function createUserForm(){
    document.getElementById("CreateUserForm").style.display = "flex";
    document.getElementById("UpdateUserForm").style.display = "none";
    document.getElementById("DeleteUserForm").style.display = "none";
    }

function updateUserForm(){
    document.getElementById("CreateUserForm").style.display = "none";
    document.getElementById("UpdateUserForm").style.display = "flex";
    document.getElementById("DeleteUserForm").style.display = "none";
    }

function deleteUserForm(){
    document.getElementById("CreateUserForm").style.display = "none";
    document.getElementById("UpdateUserForm").style.display = "none";
    document.getElementById("DeleteUserForm").style.display = "flex";
    }

function createCoinForm(){
    document.getElementById("CreateCoinForm").style.display = "flex";
    document.getElementById("UpdateCoinForm").style.display = "none";
    document.getElementById("DeleteCoinForm").style.display = "none";
    }

function updateCoinForm(){
    document.getElementById("CreateCoinForm").style.display = "none";
    document.getElementById("UpdateCoinForm").style.display = "flex";
    document.getElementById("DeleteCoinForm").style.display = "none";
    }

function deleteCoinForm(){
    document.getElementById("CreateCoinForm").style.display = "none";
    document.getElementById("UpdateCoinForm").style.display = "none";
    document.getElementById("DeleteCoinForm").style.display = "flex";
    }

function createOrderForm(){
    document.getElementById("CreateOrderForm").style.display = "flex";
    document.getElementById("UpdateOrderForm").style.display = "none";
    document.getElementById("DeleteOrderForm").style.display = "none";
    }

function updateOrderForm(){
    document.getElementById("CreateOrderForm").style.display = "none";
    document.getElementById("UpdateOrderForm").style.display = "flex";
    document.getElementById("DeleteOrderForm").style.display = "none";
    }

function deleteOrderForm(){
    document.getElementById("CreateOrderForm").style.display = "none";
    document.getElementById("UpdateOrderForm").style.display = "none";
    document.getElementById("DeleteOrderForm").style.display = "flex";
    }