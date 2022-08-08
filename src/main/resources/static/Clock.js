function clock() {
    const time = new Date();
    let hours = time.getHours();
    let mins = time.getMinutes();
    let sec = time.getSeconds();
    let h = updateTime(hours);
    let m = updateTime(mins);
    let s= updateTime(sec);
    setTimeout(clock, 1000);
    document.getElementById("time").innerHTML = h + ":" + m + ":" + s;
   
}

function updateTime(k){
    if(k < 10){
        return "0" + k;
    }
    else{
        return k;
    }
}