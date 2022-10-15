var signup = document.querySelector('.signup-btn')
var modalSignUp = document.querySelector('.modal--signup')
var closeModalSignUp = document.querySelector('.btn--auth-up')
var changeFormToIn = document.querySelector('.auth-form__switch-btn-in')

var signin = document.querySelector('.signin-btn')
var modalSignIn = document.querySelector('.modal--signin')
var closeModalSignIn = document.querySelector('.btn--auth-in')
var changeFormToUp = document.querySelector('.auth-form__switch-btn-up')

function toggleModalSignUp(e){
    console.log(e.target);
    modalSignUp.classList.toggle('hide')
}
signup.addEventListener('click', toggleModalSignUp)
closeModalSignUp.addEventListener('click', toggleModalSignUp)
modalSignUp.addEventListener('click', function (e) {
    if(e.target == e.currentTarget){
        toggleModalSignUp()
    }
})
changeFormToIn.addEventListener('click',changeform)

function changeform(){
    modalSignUp.classList.toggle('hide');
    modalSignIn.classList.toggle('hide')
}

function toggleModalSignIn(e){
    console.log(e.target);
    modalSignIn.classList.toggle('hide')
}

signin.addEventListener('click', toggleModalSignIn)
closeModalSignIn.addEventListener('click', toggleModalSignIn)
modalSignIn.addEventListener('click', function (e) {
    if(e.target == e.currentTarget){
        toggleModalSignIn()
    }
})
changeFormToUp.addEventListener('click',changeform)