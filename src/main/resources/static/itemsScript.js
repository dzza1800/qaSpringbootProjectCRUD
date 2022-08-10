fetch("/getAllItems")
//putting it into a response and converting it into json for the use in javascript

.then(response => response.json()).then(data =>

  data.forEach(i =>  {
   let nameIt = document.createElement('td');
   let listId = document.createElement('td');
   let gap = document.createElement('tr');
   let price = document.createElement('td');
   let Stock = document.createElement('td');
   let ID = document.createElement('td');
   listId.innerHTML = `${i.id}`
   nameIt.innerHTML = `${i.itemName}`;
   price.innerHTML = `${i.price}`;
   Stock.innerHTML = `${i.stock}`;
   ID.innerHTML = `${i.uniqueItemID}`;
   gap.innerHTML = " ";
   let tableRow = document.getElementById("Coins");
   
   tableRow.appendChild(listId);
   tableRow.appendChild(gap);
   tableRow.appendChild(nameIt);
   tableRow.appendChild(gap);
   tableRow.appendChild(price);
   tableRow.appendChild(gap);
   tableRow.appendChild(Stock);
   tableRow.appendChild(gap);
   tableRow.appendChild(ID);
   tableRow.appendChild(gap);
   })
 )


function submitCoin(){
    const price = document.getElementById("price").value;
    const stock = document.getElementById("coins").value;
    const name = document.getElementById("name").value;
    const uniqueID = document.getElementById("UniqueID").value;
    let t = confirm("Want to add this coin? " + name + ":" + price + ":" + stock);
    if(t == true){
    fetch("/createItems?" ,{
        method:"POST",
        body:JSON.stringify({
        "price": price,
        "stock": stock,
        "itemName": name,
        "uniqueItemID":uniqueID
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

function updateCoin(){
    const price = document.getElementById("priceUp").value;
    const stock = document.getElementById("coinsUp").value;
    const name = document.getElementById("nameUp").value;
    const listID = document.getElementById("listID").value;
    
    let t = confirm("Want to update coin id? "+ listID);
    if(t == true){
    fetch(`/updateItem?id=${listID}`,{
        method:"PUT",
        body:JSON.stringify({
        "price": price,
        "stock": stock,
        "itemName": name,
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
function deleteCoin(){
    
    const ListID = document.getElementById("ListIDDe").value;
    let t = confirm("Want to delete this Coin? " + ListID);
    if(t == true){
    fetch(`/deleteItem?id=${ListID}`,{
        method:"PUT"
    }).then(response => response.json()).then(data => {
      console.log(data);
    })
}
        else{
        alert("Operation cancelled");
    }
}