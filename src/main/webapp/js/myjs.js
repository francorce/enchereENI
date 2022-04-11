function filtrer(){
	
	let lesDivs = document.querySelectorAll("div[data-category]");
	const option = document.getElementById("categorie").value;
	
	for(let laDiv of lesDivs){
		
		if(laDiv.getAttribute('data-category')==option){
			laDiv.style.display='block';
			
		}else{
			console.log(option)
			laDiv.style.display='none';
		}
	}
}
document.getElementById("categorie").addEventListener('change', filtrer);














