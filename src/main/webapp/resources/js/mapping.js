$(document).ready(function() {
	
  $('#CafeLoungemenulist').on('click', function() {
    window.location.href =  "menulist";
  });
  
   $('#CafeLoungedashboard').on('click', function() {
    window.location.href =  "dashboard";
  });
  
  $('#CafeLoungeorderlist').on('click', function() {
    window.location.href =  "orderlist";
  });
  
  $('#notifBell').on('click', function() {
    $('#notifContainer').toggleClass('hidden');
    
  });
});