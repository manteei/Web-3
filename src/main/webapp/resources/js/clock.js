$(() => {
    const DELAY = 9000;

    function setTime(date) {
        let hours = date.getHours();
        let minutes = date.getMinutes();
        let seconds = date.getSeconds();
        let day = date.getDate();
        let month = date.getMonth() + 1;
        let year = date.getFullYear();

        hours = (hours < 10) ? '0' + hours : hours;
        minutes = (minutes < 10) ? '0' + minutes : minutes;
        seconds = (seconds < 10) ? '0' + seconds : seconds;

        day = (day < 10) ? '0' + day : day;
        month = (month < 10) ? '0' + month : month;
        year = (year < 10) ? '0' + year : year;

        $('#current-time').html(`${hours}:${minutes}:${seconds}`);
        $('#current-data').html(`${day}.${month}.${year}`);
    }

    function setCurrentDateTime() {
        setTime(new Date());
    }

    setCurrentDateTime();
    setInterval(setCurrentDateTime, DELAY);
});