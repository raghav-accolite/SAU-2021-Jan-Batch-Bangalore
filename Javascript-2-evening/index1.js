class Data{
    constructor(str){
        this.str=str;
    }
    getLength() {
        return this.str.length;
    }
    getUpperCase(){
        return this.str.toUpperCase();
    }
   
    getLowerCase(){
        return this.str.toLowerCase();
    }
    getVowel(){
        var lis = []
        for(var i=0;i<this.str.length;i++){
            let tempChar=this.str.charAt(i).toLowerCase();
            if(tempChar=='a' || tempChar=='e' || tempChar=='i' || tempChar=='o' || tempChar=='u'){
                lis.push(this.str.charAt(i));
            }
        }
        return lis;
    }
    getConsonent(){
        var lis = []
        for(var i=0;i<this.str.length;i++){
            let tempChar=this.str.charAt(i).toLowerCase();
            if(tempChar.toLowerCase() != tempChar.toUpperCase() && !(tempChar=='a' || tempChar=='e' || tempChar=='i' || tempChar=='o' || tempChar=='u')){
                lis.push(this.str.charAt(i));
            }
        }
        return lis;
    }
    NumberPresentOrNot(){
        for(var i=0;i<this.str.length;i++){
            let tempChar=this.str.charAt(i).toLowerCase();
            if((tempChar>='0' && tempChar<='9' )){
                throw "Number Present";
            }
        }
        return false;

    }

}
function showData(){
    var inp = document.getElementById('inputstr').value;
    let d = new Data(inp);
    let length=d.getLength();
    console.log(length);
    let lowercase=d.getLowerCase();
    console.log(lowercase);
    let uppercase=d.getUpperCase();
    console.log(uppercase);
    console.log(d.getVowel(),d.getConsonent());
    var info = document.getElementById("strinfo");
    document.getElementById("length").innerHTML=length;
    document.getElementById("lowercase").innerHTML=lowercase;
    document.getElementById("uppercase").innerHTML=uppercase;
    document.getElementById("vowel").innerHTML=d.getVowel();
    document.getElementById("consonent").innerHTML=d.getConsonent();
    try {
        d.NumberPresentOrNot();
        document.getElementById("numberispresent").innerHTML = ""

    } catch (error) {
        document.getElementById("numberispresent").innerHTML="Numbers is/are present in the string"
    }
    info.style.display="block";
    console.log(d.NumberPresentOrNot())

}