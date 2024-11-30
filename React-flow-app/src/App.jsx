import AboutUs from "./AboutUs";
import AdditionCal from "./AdditionCal";
import Blog from "./Blog";
import BrightText from "./BrightText";

import Buttons from "./Buttons";
import Calculator from "./Calculator";
import ContactUs from "./ContactUs";
import CourseGoal1 from "./CourseGoal1";
import CourseGoal2 from "./CourseGoal2";
import DateAndTime from "./DateAndTime";
import DateTime from "./DateTime";
import Discount from "./Discount";
import Division from "./Division";
import Fruits from "./Fruits";
import Greeting from "./Greeting";
import Increment from "./Increment";
import Increment1 from "./Increment1";
import MovieGrid from "./MovieGrid";
import Multiplication from "./Multiplication";
import SubtractionCal from "./SubtractionCal";




function App()
{
  return(
    <>
    <h1> welcome to App.jsx file...</h1>
    <AboutUs/>
   <ContactUs/>
   <Fruits/>
   <Increment1/>
   <Discount/>
   <Buttons/>
   <Increment/>
   <Greeting name='Raja'/>
   <Greeting name='sekhar'/>
   <Greeting name='Ravi'/>
   <CourseGoal1 title='Learn React'description='In-depth'/>
   <CourseGoal1 title='Learn React'description='In-depth'/>
   <CourseGoal2 title='About Ratan Sir'description='Ratan Sir Nice'/>
   <CourseGoal2 title='About Ratan Sir'description='Ratan Sir Nice'/>
   <Blog/>
  <BrightText color='red'/>
  <BrightText color='green'/>
  <BrightText color='blue'/>
  <MovieGrid/>
  <DateTime/>
  <DateAndTime/>
  <AdditionCal/>
  <SubtractionCal/>
  <Multiplication/>
  <Division/>
  <Calculator/>

   


   
   
    
    
    
    </>
  )
}
export default App;
