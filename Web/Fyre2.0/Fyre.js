var joinButton = document.querySelector('.join-button');
var payButton = document.querySelector('.confirm-button');
var cancelButton = document.querySelector('.cancel-button');

joinButton.addEventListener('click', goToSecondState);
payButton.addEventListener('click', goToThirdState);
cancelButton.addEventListener('click', goToFirstState);

var left = document.querySelector('.left');
var right = document.querySelector('.right');
var stage1 = document.querySelector('.panels-stage-1');
var stage2 = document.querySelector('.panels-stage-2');
var stage3 = document.querySelector('.panels-stage-3');

function goToFirstState() {

    left.style.display = 'block';
    right.style.width = '50%';
    stage1.style.display = 'block';
    stage2.style.display = 'none';
    stage3.style.display = 'none';
}

function goToSecondState() {

    left.style.display = 'none';
    right.style.width = '100%';
    stage1.style.display = 'none';
    stage2.style.display = 'block';
    stage3.style.display = 'none';
}

function goToThirdState() {

    stage2.style.display = 'none';
    stage3.style.display = 'block';
}