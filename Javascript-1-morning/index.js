function validate(){
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    var car = document.getElementById("cars").value;
    console.log(car);
    if(name.length==0){
        alert("Please enter Name");
        return false;
    }
    if(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(email)){   
    if(document.getElementById('gender_male').checked ||document.getElementById('gender_female').checked || document.getElementById('gender_other').checked ) {
        if(car== "Noselect"){
            alert("Please select your car");
            return false;
        }
        else{
            var gender="others";
            if(document.getElementById('gender_male').checked){
                gender="male";
            }
            else if(document.getElementById('gender_female').checked){
                gender="female"
            }
            var result={
                'name':name,
                'email':email,
                'gender': gender,
                'car':car
            }
            console.log(result);
            return true;
        }
      }else {
        alert("please selct your gender");
      }
    }
    else{
        alert("Not Valid Email");
        return false;
    }
}