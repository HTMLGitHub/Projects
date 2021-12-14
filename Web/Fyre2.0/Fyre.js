var joinButton = document.querySelector('.join-button');
joinButton.addEventListener('click', goToSecondState);

function goToSecondState() {
    var left = document.querySelector('.left');
    left.style.display = 'none';

    var stage1 = document.querySelector('.panels-stage-1');
    stage1.style.display = 'none';

    var right = document.querySelector('.right');
    right.style.width = '100%';

    var stage2 = document.querySelector('.panels-stage-2');
    stage2.style.display = 'block';
}