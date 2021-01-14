var student =[
    {
        firstname:"Raghav", 
        lastname:"Mandowara", 
        age:20 ,
        gender:"Male",
        rollno:1,
        dob:"29/05/2000"
    },
    {
        firstname:"movie", 
        lastname:"shole", 
        age:21 ,
        gender:"Male",
        rollno:2,
        dob:"29/05/2000"
    } 
];

function StoreOccupation() {
    let id = document.getElementById("rollno").value;
    let occupation= document.getElementById("occupation").value;
    for(let i=0;i<student.length;i++){
        if(student[i].rollno==id){
            student[i].occupation=occupation;
        }
    }
    
}
function getData() {
    let id = document.getElementById("getDataRollNo").value;
    document.getElementById("DataShow").innerHTML="";
    for(let i=0;i<student.length;i++){
        if(student[i].rollno==id){
            console.log(student[i]);
            document.getElementById("DataShow").innerHTML +=( student[i].firstname);
            document.getElementById("DataShow").innerHTML +="<br>";
            document.getElementById("DataShow").innerHTML +=( student[i].lastname);
            document.getElementById("DataShow").innerHTML +="<br>";
            document.getElementById("DataShow").innerHTML +=(student[i].rollno);
            document.getElementById("DataShow").innerHTML +="<br>";
            document.getElementById("DataShow").innerHTML +=( student[i].occupation);
            document.getElementById("DataShow").innerHTML +="<br>";
            document.getElementById("DataShow").innerHTML +=( student[i].dob);
            document.getElementById("DataShow").innerHTML +="<br>";
            document.getElementById("DataShow").innerHTML +="<br>";
        }
    }
    
    
    
}


function getData() {
    let id = document.getElementById("getDataRollNo").value;
    document.getElementById("DataShow").innerHTML="";
    for(let i=0;i<student.length;i++){
        if(student[i].rollno==id){
            console.log(student[i]);
            document.getElementById("DataShow").innerHTML +=( student[i].firstname);
            document.getElementById("DataShow").innerHTML +="<br>";
            document.getElementById("DataShow").innerHTML +=( student[i].lastname);
            document.getElementById("DataShow").innerHTML +="<br>";
            document.getElementById("DataShow").innerHTML +=(student[i].rollno);
            document.getElementById("DataShow").innerHTML +="<br>";
            document.getElementById("DataShow").innerHTML +=( student[i].occupation);
            document.getElementById("DataShow").innerHTML +="<br>";
            document.getElementById("DataShow").innerHTML +=( student[i].dob);
            document.getElementById("DataShow").innerHTML +="<br>";
            document.getElementById("DataShow").innerHTML +="<br>";
        }
    }
    
    
    
}
