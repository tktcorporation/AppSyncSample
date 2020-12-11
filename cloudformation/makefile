PROJECT_NAME=appsync-sample
AWS_REGION=ap-northeast-1
SHELL=/bin/bash
DEPLOY_BUCKET=appsync-sample
ENV_PREFIX=dev

default:
	echo "no commands"

create-s3-bucket:
	aws cloudformation deploy \
	--parameter-overrides \
		S3BucketName="${PROJECT_NAME}-${ENV_PREFIX}" \
	--stack-name "${PROJECT_NAME}-${ENV_PREFIX}-s3" \
	--template s3.yml \
	--region ${AWS_REGION} \
	--no-fail-on-empty-changeset

package:
	echo "package cloudformation template..."
	aws cloudformation package \
		--template-file appsync.yml \
		--output-template-file template-output.yml \
		--s3-bucket "${DEPLOY_BUCKET}-${ENV_PREFIX}" \
		--s3-prefix "${PROJECT_NAME}" \
		--region "${AWS_REGION}"

deploy: package
	echo "deploy stack..."
	aws cloudformation deploy \
		--s3-bucket "${DEPLOY_BUCKET}-${ENV_PREFIX}" \
		--template-file template-output.yml \
		--stack-name "${PROJECT_NAME}-${ENV_PREFIX}-stack" \
		--capabilities CAPABILITY_IAM CAPABILITY_NAMED_IAM \
		--region "${AWS_REGION}" \
		--tags project="${PROJECT_NAME}"


deploy-stack: package deploy