async function testApi() {
	const res = await fetch("/CafeLounge/api");
	const body = await res.text();
	console.log(body);
}

testApi()