import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

class Edit extends Component {

  constructor(props) {
    super(props);
    this.state = {
      user: {}
    };
  }

  componentDidMount() {
    axios.get('/users/'+this.props.match.params.id)
      .then(res => {
        this.setState({ user: res.data });
        console.log(this.state.user);
      });
  }

  onChange = (e) => {
    const state = this.state.user
    state[e.target.name] = e.target.value;
    this.setState({user:state});
  }

  onSubmit = (e) => {
    e.preventDefault();

    const { firstname,lastname,address, city, postalCode, phone } = this.state.user;

    axios.put('/users/'+this.props.match.params.id, { firstname,lastname, address, city, postalCode, phone })
      .then((result) => {
        this.props.history.push("/show/"+this.props.match.params.id)
      });
  }

  render() {
    return (
      <div class="container">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">
              EDIT user
            </h3>
          </div>
          <div class="panel-body">
            <h5><Link to={`/show/${this.state.user.id}`}><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> User List</Link></h5>
            <form onSubmit={this.onSubmit}>
              <div class="form-group">
                <label for="name">First Name:</label>
                <input type="text" class="form-control" name="name" value={this.state.user.firstname} onChange={this.onChange} placeholder="First Name" />
              </div>
                <div class="form-group">
                <label for="name">Last Name:</label>
                <input type="text" class="form-control" name="lastname" value={this.state.user.lastname} onChange={this.onChange} placeholder="Last Name" />
              </div>
              <div class="form-group">
                <label for="title">Address:</label>
                <input type="text" class="form-control" name="address" value={this.state.user.address} onChange={this.onChange} placeholder="Address" />
              </div>
              <div class="form-group">
                <label for="author">City:</label>
                <input type="text" class="form-control" name="city" value={this.state.user.city} onChange={this.onChange} placeholder="City" />
              </div>
              <div class="form-group">
                <label for="published_date">Phone Number:</label>
                <input type="text" class="form-control" name="phone" value={this.state.user.phone} onChange={this.onChange} placeholder="Phone Number" />
              </div>
              <div class="form-group">
                <label for="description">Email:</label>
                <input type="email" class="form-control" name="email" value={this.state.user.email} onChange={this.onChange} placeholder="Email Address" />
              </div>
              <button type="submit" class="btn btn-default">Update</button>
            </form>
          </div>
        </div>
      </div>
    );
  }
}

export default Edit;