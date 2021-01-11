function showhome(){
    var home=document.getElementsByClassName("home")[0];
    var skills=document.getElementsByClassName("skills")[0];
    var achievements=document.getElementsByClassName("achievements")[0];
    var contact=document.getElementsByClassName("contact")[0];

    home.style.display="flex";
    skills.style.display="none";
    achievements.style.display="none";
    contact.style.display="none";

}
function showskills(){
    var home=document.getElementsByClassName("home")[0];
    var skills=document.getElementsByClassName("skills")[0];
    var achievements=document.getElementsByClassName("achievements")[0];
    var contact=document.getElementsByClassName("contact")[0];

    home.style.display="none";
    skills.style.display="flex";
    achievements.style.display="none";
    contact.style.display="none";

}
function showachievements(){
    var home=document.getElementsByClassName("home")[0];
    var skills=document.getElementsByClassName("skills")[0];
    var achievements=document.getElementsByClassName("achievements")[0];
    var contact=document.getElementsByClassName("contact")[0];

    home.style.display="none";
    skills.style.display="none";
    achievements.style.display="flex";
    contact.style.display="none";

}
function showcontact(){
    var home=document.getElementsByClassName("home")[0];
    var skills=document.getElementsByClassName("skills")[0];
    var achievements=document.getElementsByClassName("achievements")[0];
    var contact=document.getElementsByClassName("contact")[0];
    home.style.display="none";
    skills.style.display="none";
    achievements.style.display="none";
    contact.style.display="flex";

}