//using fetch to retrieve information from localhost:8081/getAllUsers

fetch("/getAllUsers")
//putting it into a response and converting it into json for the use in javascript

.then(response => response.json()).then(data =>

  data.forEach(i =>  {
   let users = document.createElement('td');
   let gap = document.createElement('tr');
   let pass = document.createElement('td');
 
   users.innerHTML = `${i.accName}`;
   pass.innerHTML = `${i.password}`;
   gap.innerHTML = " ";
   
   let tableRow = document.getElementById("tab");
   
   tableRow.appendChild(users);
   tableRow.appendChild(gap);
   tableRow.appendChild(pass);
   tableRow.appendChild(gap);
   })
 )