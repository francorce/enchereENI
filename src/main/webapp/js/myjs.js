
console.log("ici1");

function filtrer(){

	console.log('ici3');
	
	let lesDivs = document.querySelectorAll("div[data-category]");
	
	for(let laDiv of lesDivs){
		if(laDiv.getAttribute('data-category')=='Livre'){
			console.log("ici 6!!!");			
			console.log(laDiv);			
			laDiv.style.display='block';
		}else{
			console.log(laDiv);
			console.log("ici 7!!!");
			laDiv.style.display='none';
		}
		
		
	}

}


document.getElementById("categorie").addEventListener('change', filtrer);

console.log("ici2");














