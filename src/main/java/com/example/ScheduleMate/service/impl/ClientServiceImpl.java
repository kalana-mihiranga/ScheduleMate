package com.example.ScheduleMate.service.impl;

import com.example.ScheduleMate.config.exception.CommonException;
import com.example.ScheduleMate.dto.EmailDto;
import com.example.ScheduleMate.dto.UserDto;
import com.example.ScheduleMate.dto.ClientDto;
import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.entity.Role;
import com.example.ScheduleMate.feignClient.EmailInterface;
import com.example.ScheduleMate.repository.ClientRepository;
import com.example.ScheduleMate.service.ClientService;
import com.example.ScheduleMate.utils.ResponseCode;
import com.example.ScheduleMate.utils.converters.ClientDtoUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final EmailInterface emailInterface;
    @Override
    public void createClient(ClientDto client) {

        Optional<Client> res = Optional.ofNullable(clientRepository.findByEmail(client.getEmail()));


        if (res.isPresent()) {
            throw new CommonException(ResponseCode.DUPLICATE);
        } else  {
            Client clientEntity = ClientDtoUtils.CLIENT_DTO_CLIENT_FUNCTION.apply(client);
            if(client.getRole().equals(String.valueOf(Role.CLIENT))) {
                clientEntity.setRole(Role.CLIENT);
            }else if(client.getRole().equals(String.valueOf(Role.BUSINESS))) {
                clientEntity.setRole(Role.BUSINESS);
            }

            String hashedPassword = PasswordUtil.hashPassword(client.getPassword());
            clientEntity.setPassword(hashedPassword);

            clientRepository.save(clientEntity);
            EmailDto emailDto = new EmailDto();
//            emailDto.setEmail("kalanamihiranga97@gmail.com");
            emailDto.setEmail("mdsmabeyrathne@gmail.com");
           // emailDto.setEmail("akmuthumala@gmail.com");
            emailDto.setSubject("\uD83D\uDC8D Congratulations on Your Wedding Day! \uD83C\uDF89\n" +
                    "\n");
            emailDto.setContent("WOW! Can you believe it? The BIG DAY is here!! \uD83D\uDE0D\uD83D\uDC8D\n" +
                    "\n" +
                    "From the moment you said \"YES,\" it's all been leading up to THIS! Today, you both embark on the most exciting, magical, and unforgettable journey together!! \uD83D\uDE80✨\n" +
                    "\n" +
                    "May your life be filled with LOVE, HAPPINESS, and countless SPECIAL MOMENTS! ❤\uFE0F\uD83C\uDF89\n" +
                    "\n" +
                    "\uD83D\uDC90✨ Here's to LOVE! ✨\uD83D\uDC90\n" +
                    "\n" +
                    "We just couldn't wait to send our BIGGEST and BEST WISHES for this amazing day!! Wishing you all the LOVE and JOY as you start this new adventure TOGETHER! ❤\uFE0F\uD83D\uDC70\uD83E\uDD35\n" +
                    "\n" +
                    "Best wishes for an AMAZING future ahead, filled with love, laughter, and lots of happy moments! \uD83D\uDE0D\uD83C\uDF89");
            emailInterface.postMail(emailDto);
        }

    }

    @Override
    public boolean authenticateClient(UserDto userDto) {
        Optional<Client> clientByEmail = Optional.ofNullable(clientRepository.findByEmail(userDto.getUserName()));


        if (clientByEmail.isPresent()) {
            // Verify the plain password against the hashed password in the database
            return PasswordUtil.verifyPassword(userDto.getPassword(), clientByEmail.get().getPassword());
        }

        return false;

    }

    @Override
    public ClientDto findClientByPhoneNumber(String phoneNumber) {

        Optional<Client> clientByPhoneNumber = Optional.ofNullable(clientRepository.findByPhoneNumber(phoneNumber));

        if(clientByPhoneNumber.isPresent()){
            return ClientDtoUtils.CLIENT_CLIENT_DTO_FUNCTION.
                    apply(clientByPhoneNumber.get());

        }else {
            throw new CommonException(ResponseCode.NOT_FOUND);
        }

    }

    @Override
    public List<ClientDto> getAllClients() {
        return  clientRepository.findAll().
                stream().map(e->ClientDtoUtils.CLIENT_CLIENT_DTO_FUNCTION.apply(e)).collect(Collectors.toList());

    }
}
