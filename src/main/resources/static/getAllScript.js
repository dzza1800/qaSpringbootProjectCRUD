//using fetch to retrieve information from localhost:8081/getAllUsers
fetch("/getAllUsers")
//putting it into a response and converting it into json for the use in javascript

.then(response => response.json()).then(data =>

  data.forEach(i =>  {
   let users = document.createElement('td');
    let mineID = document.createElement('td');
   let gap = document.createElement('tr');
   let pass = document.createElement('td');
 
   mineID.innerHTML = `${i.id}`;
   users.innerHTML = `${i.accName}`;
   pass.innerHTML = `${i.password}`;
   gap.innerHTML = " ";
   let tableRow = document.getElementById("Users");
   
   tableRow.appendChild(mineID);
   tableRow.appendChild(gap);
   tableRow.appendChild(users);
   tableRow.appendChild(gap);
   tableRow.appendChild(pass);
   tableRow.appendChild(gap);
   })
 )

function submitUser(){
    const User = document.getElementById("User").value;
    const Pass = document.getElementById("Pass").value;
    let t = confirm("Want to create this user? " + User + ":" + Pass);
    if(t == true){
    fetch("/createUser?" ,{
        method:"POST",
        body:JSON.stringify({
         "password": Pass,
         "accName" : User
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

function updateUser(){
    const User = document.getElementById("UserUp").value;
    const Pass = document.getElementById("PassUp").value;
    const userID = document.getElementById("userIDUp").value;
    let t = confirm("Want to update user id? "+ userID + ":" + User + ":" + Pass);
    if(t == true){
    fetch(`/update?id=${userID}`,{
        method:"PUT",
        body:JSON.stringify({
         "password": Pass,
         "accName" : User
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
function deleteUser(){
    
    const userID = document.getElementById("userIDDe").value;
    let t = confirm("Want to delete this user? " + userID);
    if(t == true){
    fetch(`/delete?id=${userID}`,{
        method:"PUT"
    }).then(response => response.json()).then(data => {
      console.log(data);
    })
}
        else{
        alert("Operation cancelled");
    }
}