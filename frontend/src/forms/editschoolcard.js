import React, { Component } from 'react';
import './Signup.css';
import { Link, Redirect } from 'react-router-dom'
import Alert from 'react-s-alert';
import { newschool } from '../util/APIUtils';

class EditSchoolCard extends Component {
    render() {
        if(this.props.authenticated) {
            return <Redirect
                to={{
                pathname: "/",
                state: { from: this.props.location }
            }}/>;            
        }

        return (
            <div className="signup-container">
                <div className="signup-content">
                    <h1 className="signup-title">Informacje o szkole</h1>
                    <EditSchoolCardForm {...this.props} />
                </div>
            </div>
        );
    }
}

class EditSchoolCardForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: '',
            about: '',
            description: ''
        }

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleInputChange(event) {

        const target = event.target;  

        
        const inputName = target.name; 
        const inputValue = target.value;

        const inputAbout = target.about;     
        const inputValueAbout = target.valueabout;  

        const inputDescription = target.description;     
        const inputValueDescription = target.valuedescription; 

        this.setState({
            [inputName] : inputValue,
            [inputAbout] : inputValueAbout,
            [inputDescription] : inputValueDescription
        });     

    }

    handleSubmit(event) {
   
        event.preventDefault();   
        const newSchoolRequest = Object.assign({}, this.state);
        
        newschool(newSchoolRequest)
        .then(response => {
            Alert.success("Dodano szkołę!");
        {/*this.props.history.push("/login");*/}
        }).catch(error => {
            Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');            
        });

    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="form-item">
                    <input type="text" name="name" 
                        className="form-control" placeholder="Name" 
                        value={this.state.name} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                <input type="text" name="about" 
                        className="form-control" placeholder="About"
                        valueabout={this.state.about} onChange={this.handleInputChange} 
                        maxLength="255" required/>
                </div>
                <div className="form-item">
                <textarea type="text" name="description" 
                        className="form-control" placeholder="Description"
                        valuedescription={this.state.description} onChange={this.handleInputChange} 
                        maxLength="255" required/>
                </div>
                <div className="form-item">
                    <button type="submit" className="btn btn-block btn-primary">Prześlij</button>
                </div>
            </form>                    

        );
    }
}

export default EditSchoolCard;