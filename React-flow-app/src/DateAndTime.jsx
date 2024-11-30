function DateAndTime (){
    const now = new Date();

    const currentDate = now.toDateString(); // ex:- wed oct 23 2024
    const currentTime =now.toLocaleTimeString(); //  ex:- 9:37 Am


    // normal 
    const day =now.getDate();
    const dayIndex = now.getDay();
    const monthIndex = now.getMonth();
    const year = now.getFullYear();

    // take days array 
    const days =["sun","mon","tue","wed","thu","fri","satu"]

    // take months array

    const months = ["jan","feb","mar","apr","may","june","jul","aug","sep","oct","nov","dec"]

     
    return(
        <>
        <h2>current date:{currentDate}</h2>
        <h2>current Time: {currentTime}</h2>
        <h2>current date and time {currentDate} {currentTime}</h2>
        {/* <h2> ***date and time*</h2>
        <h2>today: {days[dayIndex]} </h2>
        <h2>date: {day}</h2>
        <h2>month: {months[monthIndex]}</h2>
        <h2>year: {year}</h2> */}
        </>
    )
}
export default DateAndTime;