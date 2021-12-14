var companies = [{
        rank: 1,
        name: 'Google',
        salary: '$130k',
        logo: "https://assets.codepen.io/6060109/salaries-icon-google.png"
    },
    {
        rank: 2,
        name: 'Facebook',
        salary: '$125k',
        logo: "https://assets.codepen.io/6060109/salaries-icon-facebook.png"
    },
    {
        rank: 3,
        name: 'LinkedIn',
        salary: '$110k',
        logo: "https://assets.codepen.io/6060109/salaries-icon-linkedin.png"
    },
    {
        rank: 4,
        name: 'Uber',
        salary: '$110k',
        logo: "https://assets.codepen.io/6060109/salaries-icon-uber.png"
    },
    {
        rank: 5,
        name: 'Amazon',
        salary: '$105k',
        logo: "https://assets.codepen.io/6060109/salaries-icon-amazon.png"
    },
];

var companiesElement = document.querySelector(".companies");

// Use pattern matching to add name and salary as h3's
// Then add an img in the right place, between rank and name
for (let company of companies) {
    var newCompanyElement = `
    <li class="company">
      <h3>${company.rank}.</h3>
      <img src="${company.logo}"/>
      <h3>${company.name}</h3>
      <h3>${company.salary}</h3>
    </li>
    `;
    companiesElement.innerHTML += newCompanyElement;
}