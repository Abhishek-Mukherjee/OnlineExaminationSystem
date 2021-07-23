localStorage.setItem("timer",document.getElementById("timer").getAttribute("value"));
var timervalue = localStorage.getItem("timer");
function rules_exam()
{
  alert("Please do not open new tab. This will cancel your exam"); 
}
function form_submit() {
  document.getElementById("questionpaper").submit();
}
function examsubmit() {
  alert("Confirm to submit the exam");
}
function timer()
{
  
  if(timervalue>0)
  {
  var element = document.getElementById("timer");
  var hours = Math.floor(timervalue/3600);
  var minutes = Math.floor((timervalue/60)%60);
  var seconds = Math.floor(timervalue%60);
  element.innerHTML= "<h3>your time:: &nbsp &nbsp "+hours+":"+minutes+":"+seconds+":"+"</h3>";
  timervalue=timervalue-1;
  }
  else
  {
    alert("Times UP");
    form_submit();
    clearInterval(setinterval);
  }
}

window.onload=rules_exam(); 
document.onvisibilitychange = function() {
	  form_submit();
	};
document.getElementById("submitfrm").addEventListener("click", examsubmit);
var setinterval = setInterval(timer,1000);
