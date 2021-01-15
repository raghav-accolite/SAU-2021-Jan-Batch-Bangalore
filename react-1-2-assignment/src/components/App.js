
import React, {Component} from 'react'; 
import Child from './child';
// Bootstrap for react 
import Container from 'react-bootstrap/Container'; 
import Row from 'react-bootstrap/Row'; 
import Col from 'react-bootstrap/Col'; 
import Button from 'react-bootstrap/Button'; 
import InputGroup from 'react-bootstrap/InputGroup'; 
import FormControl from 'react-bootstrap/FormControl'; 
import ListGroup from 'react-bootstrap/ListGroup'; 
  
  
class App extends Component  { 
  constructor(props) { 
    super(props); 
  
    // Setting up state 
    this.state = { 
      userInput : "", 
      list:[],
      date:null
    } 
  } 
  
  // Set a user input value 
  updateInput(value){ 
    this.setState({ 
      userInput: value, 
    }); 
  } 
  updateInputDate(value){
    this.setState({
      date:value,
    });
  }
  // Add item if user input in not empty 
  addItem(){ 
    if(this.state.userInput !== '' ){ 
      const userInput = { 
  
        // Add a random id which is used to delete 
        id :  Math.random(), 
        time:this.state.date,
  
        // Add a user value to list 
        value : this.state.userInput 
      }; 
  
      // Update list 
      const list = [userInput,...this.state.list]; 
      
       // reset state 
      this.setState({ 
        list, 
        userInput:""
      }); 
    } 
  } 
  sortItems(){
    let list = [...this.state.list]; 
    list=list.sort((a,b)=>{
      return a.time> b.time?1:-1;
    });
    console.log(list);
    this.setState({ 
      list, 
      userInput:""
    }); 

  }
  
  // Function to delete item from list use id to delete 
  deleteItem(key){ 
    const list = [...this.state.list]; 
  
    // Filter values and leave value which we need to delete 
    const updateList = list.filter(item => item.id !== key); 
  
    // Update list in state 
    this.setState({ 
      list:updateList, 
    }); 
  
  } 
  
  render(){ 
    return(<Container> 
  
          <Row style={{ 
                  display: "flex", 
                  justifyContent: "center", 
                  alignItems: "center", 
                  fontSize: '3rem', 
                  fontWeight: 'bolder', 
                }} 
                >TODO LIST 
            </Row> 
  
           <hr/> 
          <Row> 
          <Col md={{ span: 5, offset: 4 }}> 
  
          <InputGroup className="mb-3"> 
          <FormControl 
            placeholder="add item . . . "
            size="lg"
            value = {this.state.userInput} 
            onChange = {item => this.updateInput(item.target.value)} 
            aria-label="add something"
            aria-describedby="basic-addon2"
          /> 
          <input type="Date" onChange = {item => this.updateInputDate(item.target.value)} placeholder="Time of completion"/>
          <InputGroup.Append> 
            <Button 
              variant="dark"
              size="lg"
              onClick = {()=>this.addItem()} 
              > 
              ADD 
            </Button> 
          </InputGroup.Append> 
          
        </InputGroup> 
     </Col> 
     <Col>
     <InputGroup> 
            <Button 
              variant="dark"
              size="lg"
              onClick = {()=>this.sortItems()} 
              > 
              Sort 
            </Button> 
      </InputGroup> 
     </Col>
   </Row> 
     <Child list={this.state.list} deleteItem={this.deleteItem.bind(this)}/>
     

     </Container> 
    ); 
  } 
} 
  
export default App; 
