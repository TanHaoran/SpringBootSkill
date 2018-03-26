$.ajax({
    url: "/error/getAjaxError",
    type: "POST",
    async: false,
    success: function(data) {
        debugger;
        alert(data);
    },
    error: function (response, ajaxOptions, thrownError) {
        debugger;
        alert("error");
    }
});