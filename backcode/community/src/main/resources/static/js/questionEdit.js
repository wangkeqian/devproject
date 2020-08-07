$("#submit").on('click',function () {
    checkData();
    submitForm();
});
function checkData() {
    return true;
}
function submitForm() {
    var data = $("#formData").serialize();
    $.ajax({
        type: 'POST',
        dataType: 'json',
        data: data,
        url: '/question/edit/save',
        success: function(data) {
            if (data.STATE == "SUCCESS"){
                $(location).attr('href', '/question/view/'+data.id);
            }else if (data.STATE == 'FAIL'){
                alert("未登录");
                console.log("submit FAIL");
            }else if(data.STATE == 'EXCEPTION'){
                window.location.href = data.URL;
            }


        },
        error: function(xhr, textStatus, errorThrown) {}
    })
}