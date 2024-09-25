package org.example;

import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.core.waiters.WaiterResponse;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesRequest;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesResponse;
import software.amazon.awssdk.services.ec2.model.StartInstancesRequest;
import software.amazon.awssdk.services.ec2.model.StopInstancesRequest;
import software.amazon.awssdk.services.ec2.paginators.DescribeInstancesIterable;
import software.amazon.awssdk.services.ec2.waiters.Ec2Waiter;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Ec2Client ec2 = Ec2Client.builder()
                .credentialsProvider(ProfileCredentialsProvider.create("default"))
                .region(Region.US_EAST_1)
                .build();

//        menu(ec2, "i-01647ebe380abaf3c");

        Region region = Region.US_EAST_1;
        S3Client s3 = S3Client.builder().region(region).build();

        ListBucketsResponse response = s3.listBuckets();
        List<Bucket> bucketList = response.buckets();

        for (Bucket bucket: bucketList) {
            System.out.println("Bucket name "+bucket.name());

            ListObjectsRequest request = ListObjectsRequest.builder()
                    .bucket(bucket.name())
                    .build();
            ListObjectsResponse listObjectsResponse = s3.listObjects(request);

            listObjectsResponse.contents().forEach(content ->  {
                System.out.println("Chave - " + content.key());
                System.out.println("eTag - " + content.eTag());
            });
        }
    }

    public static void listar(Ec2Client ec2) {
        DescribeInstancesRequest request = DescribeInstancesRequest.builder()
                .maxResults(10)
                .build();

        DescribeInstancesIterable instancesIterable = ec2.describeInstancesPaginator(request);
        instancesIterable.stream()
                .flatMap(r -> r.reservations().stream())
                .flatMap(reservation -> reservation.instances().stream())
                .forEach(instance -> {
                    System.out.println("""
                    Instância EC2:
                    - Instance id: %s
                    - Image id: %s
                    - Tipo: %s
                    - Estado da instância: %s
                    - Estado do Monitoramento: %s
                """.formatted(
                            instance.instanceId(),
                            instance.imageId(),
                            instance.instanceType(),
                            instance.state().name(),
                            instance.monitoring().state()
                    ));

                });
    }

    public static void parar(Ec2Client ec2, String instanceId) {
        Ec2Waiter ec2Waiter = Ec2Waiter.builder()
                .overrideConfiguration(b -> b.maxAttempts(5))
                .client(ec2)
                .build();
        StopInstancesRequest request = StopInstancesRequest.builder()
                .instanceIds(instanceId)
                .build();

        ec2.stopInstances(request);
        JOptionPane.showMessageDialog(null, "Instancia %s sendo parada. Feche e aguarde".formatted(instanceId));

        DescribeInstancesRequest instanceRequest = DescribeInstancesRequest.builder()
                .instanceIds(instanceId)
                .build();

        WaiterResponse<DescribeInstancesResponse> waiterResponse = ec2Waiter.waitUntilInstanceStopped(instanceRequest);
        waiterResponse.matched().response().ifPresent(System.out::println);

        JOptionPane.showMessageDialog(null, "Instância %s parada com sucesso".formatted(instanceId));
    }

    // Iniciar ums instância
    public static void iniciar(Ec2Client ec2, String instanceId) {
        Ec2Waiter ec2Waiter = Ec2Waiter.builder()
                .overrideConfiguration(b -> b.maxAttempts(100))
                .client(ec2)
                .build();

        StartInstancesRequest request = StartInstancesRequest.builder()
                .instanceIds(instanceId)
                .build();


        ec2.startInstances(request);
        JOptionPane.showMessageDialog(null, "Instancia %s sendo iniciada. Feche e aguarde".formatted(instanceId));

        DescribeInstancesRequest instanceRequest = DescribeInstancesRequest.builder()
                .instanceIds(instanceId)
                .build();

        WaiterResponse<DescribeInstancesResponse> waiterResponse = ec2Waiter.waitUntilInstanceRunning(instanceRequest);
        waiterResponse.matched().response().ifPresent(System.out::println);

        JOptionPane.showMessageDialog(null, "Instância %s iniciada com sucesso".formatted(instanceId));
    }

    public static void menu(Ec2Client ec2,String instance) {
        String opcao = JOptionPane.showInputDialog("""
        Escolha uma das opções:
        1 - Iniciar instância
        2 - Listar instâncias
        3 - Parar instância
        Enter - Sair
        """.formatted(instance));

        switch (opcao) {
            case "1" -> iniciar(ec2, "i-01647ebe380abaf3c");
            case "2" -> listar(ec2);
            case "3" -> parar(ec2, "i-01647ebe380abaf3c");
            default -> System.out.println("Até a próxima");
        }
    }
}