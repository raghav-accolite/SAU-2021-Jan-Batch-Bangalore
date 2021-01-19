import {StyleSheet, TouchableWithoutFeedback} from 'react-native';
import {  Dimensions } from "react-native";
let dheight= Dimensions.get("window").height;
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#465881',
    alignItems: 'center',
    justifyContent: 'center',
    width:"100%",
    height:dheight
  },
  inputText:{
    height:50,
    width:"80%",
    color:"black",
    backgroundColor:"white",
    padding:"5px"
  },
 
});
export default styles;