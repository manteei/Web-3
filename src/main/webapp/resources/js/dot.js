$(".area-wrapper").on("click", (e) => {
    const rForm = document.getElementById("rHeadVal");
    let rVal = rForm.children[0].innerHTML;

    let k = $(".area-wrapper").width() / 2;
    let xVal = Math.floor(rVal * (e.offsetX - k) * 1.25 / k * 100) / 100;
    let yVal = Math.floor(rVal * (k - e.offsetY) * 1.25 / k * 100) / 100;

    $("input[name='inputform:xVal']").val(xVal);
    $("input[name='inputform:yVal']").val(yVal);
    document.getElementById("bbutton").children[0].click();
})
