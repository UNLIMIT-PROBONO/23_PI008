import React from 'react';
import { Information } from '../../molecules/management-target/Information';
import { Col, Row } from 'antd';
import { Age } from '../../molecules/management-target/Age';

export function PrivacyInformation(props) {
    var {name, birth, address, phone_number} = props.data;
    
    return (
        <>
        <Row>
            <Col>
                <Information content={name}/>
            </Col>
            <Col>
                <Age birth={birth} />
            </Col>
        </Row>
        <Row>
            <Information label="주소" content={address}/>
        </Row>
        <Row>    
            <Information label="번호" content={phone_number}/>
        </Row>
        </>
    )
}