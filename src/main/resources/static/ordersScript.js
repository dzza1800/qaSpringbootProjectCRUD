fetch("/getAllOrders")
//putting it into a response and converting it into json for the use in javascript

.then(response => response.json()).then(data =>

  data.forEach(i =>  {
   let gap = document.createElement('tr');
   let Quantity = document.createElement('td');
   let process = document.createElement('td');
   let ID = document.createElement('td');
   let mainID = document.createElement('td');
    
   ID.innerHTML = `${i.orderUniqueID}`;
   Quantity.innerHTML = `${i.orderQuantity}`;
   process.innerHTML = `${i.isProcessing}`;
    mainID.innerHTML = `${i.id}`;
   gap.innerHTML = " ";
   let tableRow = document.getElementById("Orders");
   
   tableRow.appendChild(mainID);
   tableRow.appendChild(gap); 
   tableRow.appendChild(ID);
   tableRow.appendChild(gap);
   tableRow.appendChild(Quantity);
   tableRow.appendChild(gap);
   tableRow.appendChild(process);
   tableRow.appendChild(gap);
   })
 )
function submitOrder(){
    const processID = document.getElementById("Process").value;
    const Quantity = document.getElementById("Quantity").value;
    let t = confirm("Want to submit a transaction id? " + Quantity + ":" + processID);
    if(t == true){
    fetch("/createOrder?" ,{
        method:"POST",
        body:JSON.stringify({
        "isProcessing": processID,
        "orderQuantity":Quantity
          }),
        headers:{
          "Content-Type":"application/json"
        }
    }).then(response => response.json()).then(data => {
        console.log(data);
    })
}
            else{
        alert("Operation cancelled");
    }
}

function updateOrder(){
   const processID = document.getElementById("ProcessUp").value;
    const Quantity = document.getElementById("QuantityUp").value;
    const orderID = document.getElementById("orderIDUp").value;
    let t = confirm("Want to update a transaction? "+ orderID + ":" + Quantity + ":" + processID);
    if(t == true){
    fetch(`/updateOrder?id=${orderID}`,{
        method:"PUT",
        body:JSON.stringify({
        "isProcessing": processID,
        "orderQuantity":Quantity
          }),
        headers:{
          "Content-Type":"application/json"
        }
    }).then(response => response.json()).then(data => {
      
    })
}
        else{
        alert("Operation cancelled");
    }
}
function deleteOrder(){
    
    const orderID = document.getElementById("OrderIDDe").value;
    let t = confirm("Want to delete this order? " + orderID);
    if(t == true){
    fetch(`/deleteOrderUnique?id=${orderID}`,{
        method:"PUT"
    }).then(response => response.json()).then(data => {
      console.log(data);
    })
}
        else{
        alert("Operation cancelled");
    }
}