package com.loyalty.dxvalley.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvitationDTO {
    private String inviter;
    private String invitee;
}
