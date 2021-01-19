import {StyleSheet,Dimensions} from 'react-native';
import { color } from 'react-native-reanimated';


const dwidth =Dimensions.get("window").width;
const styles = StyleSheet.create({
    cardContainer:{
        width:dwidth,
        flex:1,
        flexGrow:1,
        justifyContent:"center",
        alignItems:"center"

    },
    card:{
        flexDirection:"row",
        alignContent:"space-between",
        justifyContent:"space-between",
        width:"80%",
        color:"black",
        backgroundColor:"white",
        marginVertical:"5px",
        padding:"5px"
        
    },
    deletebtn:{
        padding:"5px",
        borderColor:"black",
        borderRadius:2,
        borderStyle:"solid"
        
    }
    
});
export default styles;