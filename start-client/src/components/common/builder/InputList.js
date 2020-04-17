import PropTypes from 'prop-types'
import React from 'react'

const numbers = [1, 2, 3, 4, 5];

const InputList = ({ id, text, value, onChange, disabled, inputRef }) => (
    <>
  <div className='control control-inline'>
    <label htmlFor={id}>{text}</label>
    <input
      type='text'
      id={id}
      className='input'
      disabled={disabled}
      onChange={onChange}
      ref={inputRef}
    />
    </div>
  <div className='control control-inline'>
    <label></label>
    <TagList tags={value}></TagList>
  </div>
  </>
)

function ListItem(props) {
    return <li>{props.value}<a onClick={e=>{
        console.log(e)
    }}>[❌]</a></li>;
}
  
function TagList(props) {
    const tags = props.tags;
    const listItems = tags.map((tag) =>
        <ListItem key={tag.toString()} value={tag} />
    );
    return (
        <ul className="input-list">
            {listItems}
        </ul>
    );
}
  

InputList.defaultProps = {
  disabled: false,
  inputRef: null,
}

InputList.propTypes = {
  id: PropTypes.string.isRequired,
  text: PropTypes.string.isRequired,
  value: PropTypes.array.isRequired,
  onChange: PropTypes.func.isRequired,
  inputRef: PropTypes.oneOfType([
    PropTypes.func,
    PropTypes.shape({ current: PropTypes.instanceOf(Element) }),
  ]),
  disabled: PropTypes.bool,
}

export default InputList
