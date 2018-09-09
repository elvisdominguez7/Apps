import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';
import { Link } from 'react-router-dom';

class Create extends Component {

  constructor() {
    super();
    this.state = {
      firstname: '',
      lastname: '',
      address: '',
      city: '',
      phone: '',
      email: ''
    };
  }
  onChange = (e) => {
    const state = this.state
    state[e.target.name] = e.target.value;
    this.setState(state);
  }

  onSubmit = (e) => {
    e.preventDefault();

    const { firstname,lastname, address, city, phone, email } = this.state;

    axios.post('/users', { firstname,lastname, address, city, phone, email })
      .then((result) => {
        this.props.history.push("/")
      });
  }

  render() {
	  const { firstname,lastname, address, city, phone, email } = this.state;
    return (
      <div class="container">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">
              ADD User
            </h3>
          </div>
          <div class="panel-body">
            <h5><Link to="/"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> Users List</Link></h5>
            <form onSubmit={this.onSubmit}>
              <div class="form-group">
                <label for="isbn">First Name:</label>
                <input type="text" class="form-control" name="firstname" value={firstname} onChange={this.onChange} placeholder="First Name" />
              </div>
                <div class="form-group">
                <label for="isbn">Last Name:</label>
                <input type="text" class="form-control" name="lastname" value={lastname} onChange={this.onChange} placeholder="Last Name" />
              </div>
              <div class="form-group">
                <label for="title">Address:</label>
                <input type="text" class="form-control" name="address" value={address} onChange={this.onChange} placeholder="Address" />
              </div>
              <div class="form-group">
                <label for="author">City:</label>
                <input type="text" class="form-control" name="city" value={city} onChange={this.onChange} placeholder="City" />
              </div>
              <div class="form-group">
                <label for="published_date">Phone:</label>
                <input type="text" class="form-control" name="phone" value={phone} onChange={this.onChange} placeholder="Phone Number" />
              </div>
              <div class="form-group">
                <label for="publisher">Email:</label>
                <input type="email" class="form-control" name="email" value={email} onChange={this.onChange} placeholder="Email Address" />
              </div>
              <button type="submit" class="btn btn-default">Submit</button>
            </form>
          </div>
        </div>
      </div>
    );
  }
}

export default Create;