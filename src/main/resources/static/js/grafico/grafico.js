//$('#gerarGrafico').on('click', function(event) {
//	 e.preventDefault();
//	 var str = $("#tecnologia").val();
//	 var str2 = $("#percentual").val();
//});	


window.onload = $(function() {

	var config = {
			type : 'doughnut',
			data : {
				labels : ["Spring"],
				datasets : [ {
					data : [ 21, 23, 50, 32, 33, 39, 40, 42 ],
					backgroundColor : [ "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db" ]
//					hoverBackgroundColor : [ "#FFFFFF", "#FFFFFF", "#FFFFFF" ]
				} ]
			},
			options: {
				cutoutPercentage:80,
			    elements: {
			      center: {
			        text: 'TESTE',
			        color: '#000000', // Default is #000000
			        fontStyle: 'Arial', // Default is Arial
			        responsive: true,
			        maintainAspectRatio: false
			      }
			    }
			  }
		};
		
	var ctx = document.getElementById("grafico1").getContext('2d');
	var myChart = new Chart(ctx, config);
	//document.getElementById("g1").contentEditable = true;

	var config = {
			type : 'doughnut',
			data : {
				labels : ["Java"],
				datasets : [ {
					data : [ 21, 23, 50, 32, 33, 39, 40, 42 ],
					backgroundColor : [ "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db" ]
				} ]
			},
			options: {
				cutoutPercentage:80,
				rotation: Math.PI * 1,
				animation:{
				  animateScale:true	
				},
			    elements: {
			      center: {
			        text: 'TESTE',
			        color: '#000000', // Default is #000000
			        fontStyle: 'Arial', // Default is Arial
			        responsive: true,
			        maintainAspectRatio: false
			      }
			    }
			  }
		};
		
	var ctx = document.getElementById("grafico2").getContext('2d');
	var myChart = new Chart(ctx, config);

	var config = {
			type : 'doughnut',
			data : {
				labels : ["React Native"],
				datasets : [ {
					data : [ 21, 23, 50, 32, 33, 39, 40, 42 ],
					backgroundColor : [ "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db" ]
				} ]
			},
			options: {
				cutoutPercentage:80,
			    elements: {
			      center: {
			        text: 'TESTE',
			        color: '#000000', // Default is #000000
			        fontStyle: 'Arial', // Default is Arial
			        responsive: true,
			        maintainAspectRatio: false
			      }
			    }
			  }
		};
		
	var ctx = document.getElementById("grafico3").getContext('2d');
	var myChart = new Chart(ctx, config);

	var config = {
			type : 'doughnut',
			data : {
				labels : ["React Native"],
				datasets : [ {
					data : [ 21, 23, 50, 32, 33, 39, 40, 42 ],
					backgroundColor : [ "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db" ]
				} ]
			},
			options: {
				cutoutPercentage:80,
			    elements: {
			      center: {
			        text: 'TESTE',
			        color: '#000000', // Default is #000000
			        fontStyle: 'Arial', // Default is Arial
			        responsive: true,
			        maintainAspectRatio: false
			      }
			    }
			  }
		};
		
	var ctx = document.getElementById("grafico4").getContext('2d');
	var myChart = new Chart(ctx, config);

	var chart = this;
	var config = {
			type : 'doughnut',
			data : {
				labels : ["React Native"],
				datasets : [ {
					data : [ 21, 23, 50, 32, 33, 39, 40, 42 ],
					backgroundColor : [ "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db" ]
				} ]
			},
			options: {
				cutoutPercentage:80,
			    elements: {
			      center: {
			        text: 'TESTE',
			        color: '#000000', // Default is #000000
			        fontStyle: 'Arial', // Default is Arial
			        responsive: true,
			        maintainAspectRatio: false
			      }
			    }
			  }
		};
		
	var ctx = document.getElementById("grafico5").getContext('2d');
	var myChart = new Chart(ctx, config);
	var config = {
			type : 'doughnut',
			data : {
				labels : ["React Native"],
				datasets : [ {
					data : [ 21, 23, 50, 32, 33, 39, 40, 42 ],
					backgroundColor : [ "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db" ]
				} ]
			},
			options: {
				cutoutPercentage:80,
			    elements: {
			      center: {
			        text: 'TESTE',
			        color: '#000000', // Default is #000000
			        fontStyle: 'Arial', // Default is Arial
			        responsive: true,
			        maintainAspectRatio: false
			      }
			    }
			  }
		};

});