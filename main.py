import os
import re

# File Inputs
csv_file = 'FFPMappings.csv'
java_directory = './java_files/'  # Directory containing .java files
output_directory = './updated_files/'  # Directory to save updated .java files

# Make Dict
mapping = {}

with open(csv_file, 'r') as file:
    for line in file:
        parts = line.strip().split(',')
        if len(parts) == 2:
            old_name, new_name = parts
            mapping[old_name] = new_name

# Ensure output directory exists
if not os.path.exists(output_directory):
    os.makedirs(output_directory)

# Replace func, field, and p
def replace_names(match):
    full_match = match.group(0)
    if full_match in mapping:
        replacement_type = full_match.split('_')[0] + '_'
        replacement_counts[replacement_type] += 1
        return mapping[full_match]
    return full_match

patterns = [
    re.compile(r'\b(func_\w+)\b'),
    re.compile(r'\b(field_\w+)\b'),
    re.compile(r'\b(p_\w+)\b')
]

# Process each .java file in the directory and subdirectories
for root, dirs, files in os.walk(java_directory):
    for java_file in files:
        if java_file.endswith('.java'):
            input_file_path = os.path.join(root, java_file)

            # Maintain directory structure in the output
            relative_path = os.path.relpath(input_file_path, java_directory)
            output_file_path = os.path.join(output_directory, relative_path)
            output_dir = os.path.dirname(output_file_path)

            if not os.path.exists(output_dir):
                os.makedirs(output_dir)

            # Initialize replacement counts for the current file
            replacement_counts = {
                'func_': 0,
                'field_': 0,
                'p_': 0
            }

            with open(input_file_path, 'r') as file:
                java_code = file.read()

            # Update code
            updated_code = java_code
            for pattern in patterns:
                updated_code = pattern.sub(replace_names, updated_code)

            # Write updated code to file
            with open(output_file_path, 'w') as file:
                file.write(updated_code)

            # Print replacement counts for the current file
            print(f"Processed {java_file}:")
            print(f"func_ replacements: {replacement_counts['func_']}")
            print(f"field_ replacements: {replacement_counts['field_']}")
            print(f"p_ replacements: {replacement_counts['p_']}")
            print(f"Updated Java source code saved as {output_file_path}")
