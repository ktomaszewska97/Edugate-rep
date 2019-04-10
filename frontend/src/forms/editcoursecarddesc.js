import React, { Component } from 'react';
import './Signup.css';
import { Link, Redirect } from 'react-router-dom'
import Alert from 'react-s-alert';

class EditCardDesc extends Component {
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
                    <h1 className="signup-title">Uzupełnij szczegóły</h1>
                    <EditCardDescForm {...this.props} />
                </div>
            </div>
        );
    }
}

class EditCardDescForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            note: '',
            description: ''
        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleInputChange(event) {
        const target = event.target;
        const inputNote = target.note;        
        const inputDescription = target.description;

        this.setState({
            [inputNote] : inputNote,
            [inputDescription] : inputDescription
        });        
    }

    handleSubmit(event) {
        event.preventDefault();   

        const signUpRequest = Object.assign({}, this.state);
        {/*}
        signup(signUpRequest)
        .then(response => {
            Alert.success("You're successfully registered. Now you can use Edugate!");
            this.props.history.push("/login");
        }).catch(error => {
            Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');            
        });
    */}
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="form-item">
                    <input type="text" name="note" 
                        className="form-control" placeholder="Note"
                        note={this.state.note} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                    <textarea type="text" name="description" 
                        className="form-control" placeholder="Description"
                        description={this.state.description} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                    <button type="submit" className="btn btn-block btn-primary" >Prześlij!</button>
                </div>
            </form>               

        );
    }
}

export default EditCardDesc;