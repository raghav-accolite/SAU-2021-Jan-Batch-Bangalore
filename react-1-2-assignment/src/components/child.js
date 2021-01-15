
import React, {Component} from 'react'; 
  
// Bootstrap for react 
import Container from 'react-bootstrap/Container'; 
import Row from 'react-bootstrap/Row'; 
import Col from 'react-bootstrap/Col'; 
import Button from 'react-bootstrap/Button'; 
import InputGroup from 'react-bootstrap/InputGroup'; 
import FormControl from 'react-bootstrap/FormControl'; 
import ListGroup from 'react-bootstrap/ListGroup'; 
  
  
class Child extends Component  { 
  constructor(props) { 
    super(props); 
    } 
    
  render(){ 
    return(
        <Container>
        <Row>
            <Col md={{ span: 5, offset: 4 }}> 
                <ListGroup> 
                {/* map over and print items */} 
                {this.props.list.map(item => {return( 
        
                    <ListGroup.Item variant="dark" action  
                    onClick = { () => this.props.deleteItem(item.id) }> 
                    <p>Task - {item.value}</p>
                     <p>Completion Time - {item.time}</p>
                    </ListGroup.Item> 
        
                )})} 
                </ListGroup> 
            </Col> 
   </Row> 
     </Container> 
    ); 
  } 
} 
  
export default Child; 
