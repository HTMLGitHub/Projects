var girls = [
    { picture: "https://assets.codepen.io/6060109/tinder-girl-1.png" },
    { picture: "https://assets.codepen.io/6060109/tinder-girl-2.png" },
    { picture: "https://assets.codepen.io/6060109/tinder-girl-3.png" },
];

var feed = document.querySelector('.feed');

for (let girl of girls) {
    feed.innerHTML += `<img src="${girl.picture}"/>`;
}

var gotMatch = document.querySelector(".got-match");

var greenHeart = document.querySelector(".green-heart").addEventListener('click', function() {
    gotMatch.style.display = 'flex';
});

var keepSwiping = document.querySelector('.keep-swiping').addEventListener('click', function() {
    gotMatch.style.display = 'none';
});