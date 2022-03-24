/**
 * 
 */
 const form  = document.getElementsByTagName('form')[0];

const uname = document.getElementById('name');
const email = document.getElementById('email');
const pass = document.getElementById('password');
const pass2 = document.getElementById('password2');
const unameError = document.querySelector('#name + span.error');
const emailError = document.querySelector('#email + span.error');
const passError = document.querySelector('#password + span.error');
const pass2Error = document.querySelector('#password2 + span.error');

uname.addEventListener('input', function (event) {
  if (uname.validity.valid) {
    unameError.textContent = '';
    unameError.className = 'error';
  } else {
    showError();
  }
});

email.addEventListener('input', function (event) {
 
  if (email.validity.valid) {
    emailError.textContent = '';
    emailError.className = 'error';
  } else {
    showError();
  }
});

pass.addEventListener('input', function (event) {
  if (pass.validity.valid) {
    passError.textContent = '';
    passError.className = 'error';
  } else {
    showError();
  }
});

pass2.addEventListener('input', function (event) {
  if (pass2.validity.valid) {
    pass2Error.textContent = '';
    pass2Error.className = 'error';
  } else {
    showError();
  }
});

form.addEventListener('submit', function (event) {

if(!uname.validity.valid){
  showError();
  event.preventDefault();
}

 
  if(!email.validity.valid) {
   
    showError();
   
    event.preventDefault();
  }


  if(!pass.validity.valid){
    showError();
    event.preventDefault();
  }

  if(!pass2.validity.valid){
    showError();
    event.preventDefault();
  }
});

function showError() {

if(uname.validity.valueMissing){
  unameError.textContent = 'You need to fill the user name.';
}else if(uname.validity.tooShort){
  unameError.textContent=`username should be at least ${uname.minlength="3"} characters.`;
}else if(email.validity.valueMissing) {
   
    emailError.textContent = 'You need to enter an e-mail address.';
  } else if(email.validity.typeMismatch) {
   
    emailError.textContent = 'Entered value needs to be an e-mail address.';
  } else if(email.validity.tooShort) {
   
    emailError.textContent = `Enter the proper email address.`;
  }else if(pass.validity.valueMissing){
  passError.textContent = 'you need to fill the password.';
}else if(pass.validity.tooShort){
  passError.textContent=`password should be at least ${pass.minlength="8"} characters.`;
}else if(pass2.validity.valueMissing){
  pass2Error.textContent = 'you need to fill the password.';
}else if(pass2 !== pass){
  pass2Error.textContent="Conform pass is miss match";
}else{
  pass2Error.textContent="Conform pass is  match";
}


 

 
  unameError.className = 'error active';
  emailError.className = 'error active';
  passError.className = 'error active';
  pass2Error.className = 'error active';
}
