import React, { Component } from 'react';
import './Signup.css';
import { Link, Redirect } from 'react-router-dom'
import Alert from 'react-s-alert';
import { newdepartament } from '../util/APIUtils';

class EditDepartamentCard extends Component {
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
                    <h1 className="signup-title">Informacje o wydziale</h1>
                    <EditDepartamentCardForm {...this.props} />
                </div>
            </div>
        );
    }
}

class EditDepartamentCardForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: '',
            about: ''
        }

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleInputChange(event) {
        const target = event.target;       
        const inputName = target.name;
        const inputAbout = target.about;

        this.setState({
            [inputName] : inputName,
            [inputAbout] : inputAbout
        });     

    }

    handleSubmit(event) {
   
        event.preventDefault();   
        const newDepartamentRequest = Object.assign({}, this.state);
        
        newdepartament(newDepartamentRequest)
        .then(response => {
            Alert.success("Dodano wydział!");
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
                        name={this.state.fieldOfStudy} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                <textarea type="text" name="d" 
                        className="form-control" placeholder="About"
                        about={this.state.description} onChange={this.handleInputChange} 
                        maxLength="255" required/>
                </div>
                <div className="form-item">
                    <button type="submit" className="btn btn-block btn-primary">Prześlij</button>
                </div>
            </form>                    

        );
    }
}

export default EditDepartamentCard;