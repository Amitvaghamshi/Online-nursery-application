
document.getElementById("login").addEventListener("click",(event)=>{
    event.preventDefault()
    login();
})

const login= async ()=> {
let loginas=document.getElementById("la").value ;

if(loginas=="customer"){
console.log("amit")

    let emai=document.getElementById("email").value;
    let passwor=document.getElementById("pass").value ;


let send_data={
    email:emai,
    password:passwor
}

    let responce=await fetch(`http://localhost:8080/login`,{
        method:"POST",
        body:JSON.stringify(send_data),
        headers:{
            "Content-Type":"application/json",
        }
      });

      let data=await responce.json();
      console.log(data);

}else{

}



}


const getdata= async()=>{

    let responce=fetch(``)

}

