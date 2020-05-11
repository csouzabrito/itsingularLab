window.onload = $(function() {

	var config = {
		type : 'doughnut',
		data : {
			labels : ["Spring"],
			datasets : [ {
				data : [ 21, 23, 50, 32, 33, 39, 40, 42 ],
				backgroundColor : [ "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db", "#3498db" ]
//				hoverBackgroundColor : [ "#FFFFFF", "#FFFFFF", "#FFFFFF" ]
			} ]
		},
		options: {
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
	
var ctx = document.getElementById("myChart").getContext('2d');
ctx.height = 50;
var myChart = new Chart(ctx, config);

// var myChart = new Chart(ctx, {
// type: 'doughnut',
// data: {
// labels: ["Spring"],
//	    datasets: [{
//	      backgroundColor: [
//	        "#3498db",
//	        "#3498db",
//	        "#3498db",
//	        "#3498db",
//	        "#3498db",
//	        "#3498db",
//	        "#3498db"
//	      ],
//	      data: [12, 19, 3, 17, 28, 24, 1,12]
//	    }]
//	  }
});


$('.button-ano').on('click', function(event) {
	event.preventDefault();
	
});	