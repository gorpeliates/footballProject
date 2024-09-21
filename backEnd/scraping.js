
const Pool = require('pg').Pool

const pool = new Pool({
    user: 'postgres',
    host: 'localhost',
    database: 'footballProject',
    password: 'atesdatabase',
    port: 5432,
})

const puppeteer = require('puppeteer');

async function getData()  {
    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    await page.goto('https://fbref.com/en/comps/9/misc/Premier-League-Stats');


    // headers
    const header = await page.evaluate(() => {
        const row = document.querySelector('#stats_misc > thead > tr:nth-child(2)');
        return row ? row.innerText : null
    });

    console.log(header)
    const rowData = await page.evaluate(() => {
        const row = document.querySelector('#stats_misc > tbody > tr:nth-child(9)');
        return row ? row.innerText : 'Row not found';
    });

    console.log(rowData);

    await browser.close();
}

getData()